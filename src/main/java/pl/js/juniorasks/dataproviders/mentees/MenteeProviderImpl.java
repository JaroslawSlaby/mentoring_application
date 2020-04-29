package pl.js.juniorasks.dataproviders.mentees;

import org.modelmapper.ModelMapper;
import pl.js.juniorasks.models.Mentee;

import java.util.Optional;

public class MenteeProviderImpl implements MenteeProvider {

    private final MenteeRepository menteeRepository;
    private final ModelMapper modelMapper;

    public MenteeProviderImpl(MenteeRepository menteeRepository, ModelMapper modelMapper) {
        this.menteeRepository = menteeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Mentee getMentee(String menteeNick) {
        Optional<MenteeDAO> menteeOptional = menteeRepository.findById(menteeNick);
        MenteeDAO menteeDAO = menteeOptional.orElseThrow();
        return modelMapper.map(menteeDAO, Mentee.class);
    }

    @Override
    public void saveMentee(Mentee mentee) {
        MenteeDAO menteeDAO = modelMapper.map(mentee, MenteeDAO.class);
        menteeRepository.save(menteeDAO);
    }

    @Override
    public Mentee removeMentee(String menteeNick) {
        Optional<MenteeDAO> menteeOptional = menteeRepository.findById(menteeNick);
        MenteeDAO menteeDAO = menteeOptional.orElseThrow();
        menteeRepository.delete(menteeDAO);
        return modelMapper.map(menteeDAO, Mentee.class);
    }
}
