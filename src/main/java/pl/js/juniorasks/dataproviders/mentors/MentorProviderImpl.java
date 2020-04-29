package pl.js.juniorasks.dataproviders.mentors;

import org.modelmapper.ModelMapper;
import pl.js.juniorasks.models.Mentor;

import java.util.Optional;

public class MentorProviderImpl implements MentorProvider {

    private final MentorRepository mentorRepository;
    private final ModelMapper modelMapper;

    public MentorProviderImpl(MentorRepository mentorRepository, ModelMapper modelMapper) {
        this.mentorRepository = mentorRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Mentor getMentor(String mentorNick) {
        Optional<MentorDAO> mentorOptional = mentorRepository.findById(mentorNick);
        MentorDAO mentorDAO = mentorOptional.orElseThrow();
        return modelMapper.map(mentorDAO, Mentor.class);
    }

    @Override
    public void saveMentor(Mentor mentor) {
        MentorDAO mentorDAO = modelMapper.map(mentor, MentorDAO.class);
        mentorRepository.save(mentorDAO);
    }

    @Override
    public Mentor removeMentor(String mentorNick) {
        Optional<MentorDAO> mentorOptional = mentorRepository.findById(mentorNick);
        MentorDAO mentorDAO = mentorOptional.orElseThrow();
        mentorRepository.delete(mentorDAO);
        return modelMapper.map(mentorDAO, Mentor.class);
    }
}
