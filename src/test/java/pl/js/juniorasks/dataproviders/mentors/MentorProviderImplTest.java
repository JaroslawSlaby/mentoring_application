package pl.js.juniorasks.dataproviders.mentors;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import pl.js.juniorasks.models.Mentor;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class MentorProviderImplTest {

    private static final String MENTOR_NICK = "TestMentorNick";
    private static final String MENTOR_MAIL = "TestMentorMail";

    @Test
    void getMentorOkTest() {
        MentorDAO dao = new MentorDAO(MENTOR_NICK, MENTOR_MAIL);
        MentorRepository mentorRepository = mock(MentorRepository.class);
        when(mentorRepository.findById(MENTOR_NICK)).thenReturn(Optional.of(dao));
        ModelMapper mapper = createModelMapper();
        MentorProvider mentorProvider = new MentorProviderImpl(mentorRepository, mapper);

        Mentor mentor = mentorProvider.getMentor(MENTOR_NICK);

        assertEquals(MENTOR_NICK, mentor.getNick());
        assertEquals(MENTOR_MAIL, mentor.getEmail());

        verify(mentorRepository).findById(MENTOR_NICK);
    }

    @Test
    void getMentorErrorTest() {
        MentorRepository mentorRepository = mock(MentorRepository.class);
        when(mentorRepository.findById(MENTOR_NICK)).thenReturn(Optional.empty());
        ModelMapper mapper = createModelMapper();
        MentorProvider mentorProvider = new MentorProviderImpl(mentorRepository, mapper);

        assertThrows(NoSuchElementException.class, () -> mentorProvider.getMentor(MENTOR_NICK));
    }

    @Test
    void addMentorOkTest() {
        Mentor mentor = new Mentor(MENTOR_NICK, MENTOR_MAIL);
        MentorRepository mentorRepository = mock(MentorRepository.class);
        ModelMapper mapper = createModelMapper();
        MentorProvider mentorProvider = new MentorProviderImpl(mentorRepository, mapper);

        mentorProvider.saveMentor(mentor);

        verify(mentorRepository).save(any(MentorDAO.class));
    }

    @Test
    void removeMentorOkTest() {
        MentorDAO dao = new MentorDAO(MENTOR_NICK, MENTOR_MAIL);
        MentorRepository mentorRepository = mock(MentorRepository.class);
        when(mentorRepository.findById(MENTOR_NICK)).thenReturn(Optional.of(dao));
        ModelMapper mapper = createModelMapper();
        MentorProvider mentorProvider = new MentorProviderImpl(mentorRepository, mapper);

        Mentor mentor = mentorProvider.removeMentor(MENTOR_NICK);

        assertEquals(MENTOR_NICK, mentor.getNick());
        assertEquals(MENTOR_MAIL, mentor.getEmail());

        verify(mentorRepository).findById(MENTOR_NICK);
        verify(mentorRepository).delete(dao);
    }

    @Test
    void removeMentorErrorTest() {
        MentorRepository mentorRepository = mock(MentorRepository.class);
        when(mentorRepository.findById(MENTOR_NICK)).thenReturn(Optional.empty());
        ModelMapper mapper = createModelMapper();
        MentorProvider mentorProvider = new MentorProviderImpl(mentorRepository, mapper);

        assertThrows(NoSuchElementException.class, () -> mentorProvider.removeMentor(MENTOR_NICK));
    }


    private static ModelMapper createModelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
                .setFieldMatchingEnabled(true);
        return mapper;
    }

}