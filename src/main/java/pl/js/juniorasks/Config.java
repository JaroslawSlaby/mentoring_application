package pl.js.juniorasks;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.js.juniorasks.assignmentoperations.AssignmentProcessor;
import pl.js.juniorasks.dataproviders.mentees.MenteeProvider;
import pl.js.juniorasks.dataproviders.mentees.MenteeProviderImpl;
import pl.js.juniorasks.dataproviders.mentees.MenteeRepository;
import pl.js.juniorasks.dataproviders.mentors.MentorProvider;
import pl.js.juniorasks.dataproviders.mentors.MentorProviderImpl;
import pl.js.juniorasks.dataproviders.mentors.MentorRepository;
import pl.js.juniorasks.useroperations.mentees.MenteeProcessor;
import pl.js.juniorasks.useroperations.mentors.MentorProcessor;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Config {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
                .setFieldAccessLevel(AccessLevel.PRIVATE)
                .setFieldMatchingEnabled(true);
        return mapper;
    }

    @Bean
    public MentorProvider mentorProvider(MentorRepository mentorRepository, ModelMapper modelMapper) {
        return new MentorProviderImpl(mentorRepository, modelMapper);
    }

    @Bean
    public MentorProcessor mentorProcessor(MentorProvider mentorProvider) {
        return new MentorProcessor(mentorProvider);
    }

    @Bean
    public MenteeProvider menteeProvider(MenteeRepository menteeRepository, ModelMapper modelMapper) {
        return new MenteeProviderImpl(menteeRepository, modelMapper);
    }

    @Bean
    public MenteeProcessor menteeProcessor(MenteeProvider menteeProvider) {
        return new MenteeProcessor(menteeProvider);
    }

    @Bean
    public AssignmentProcessor assignmentProcessor(MentorProvider mentorProvider, MenteeProvider menteeProvider) {
        return new AssignmentProcessor(mentorProvider, menteeProvider);
    }


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

}
