package pl.js.juniorasks.dataproviders.mentees;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import pl.js.juniorasks.models.Mentee;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class MenteeProviderImplTest {

    private static final String MENTEE_NICK = "TestMenteeNick";
    private static final String MENTEE_MAIL = "TestMenteeMail";

    @Test
    void getMenteeOkTest() {
        MenteeDAO dao = new MenteeDAO(MENTEE_NICK, MENTEE_MAIL);
        MenteeRepository menteeRepository = mock(MenteeRepository.class);
        when(menteeRepository.findById(MENTEE_NICK)).thenReturn(Optional.of(dao));
        ModelMapper mapper = createModelMapper();
        MenteeProvider menteeProvider = new MenteeProviderImpl(menteeRepository, mapper);

        Mentee mentee = menteeProvider.getMentee(MENTEE_NICK);

        assertEquals(MENTEE_NICK, mentee.getNick());
        assertEquals(MENTEE_MAIL, mentee.getEmail());

        verify(menteeRepository).findById(MENTEE_NICK);
    }

    @Test
    void getMenteeErrorTest() {
        MenteeRepository menteeRepository = mock(MenteeRepository.class);
        when(menteeRepository.findById(MENTEE_NICK)).thenReturn(Optional.empty());
        ModelMapper mapper = createModelMapper();
        MenteeProvider menteeProvider = new MenteeProviderImpl(menteeRepository, mapper);

        assertThrows(NoSuchElementException.class, () -> menteeProvider.getMentee(MENTEE_NICK));
    }

    @Test
    void addMenteeOkTest() {
        Mentee mentee = new Mentee(MENTEE_NICK, MENTEE_MAIL);
        MenteeRepository menteeRepository = mock(MenteeRepository.class);
        ModelMapper mapper = createModelMapper();
        MenteeProvider menteeProvider = new MenteeProviderImpl(menteeRepository, mapper);

        menteeProvider.saveMentee(mentee);

        verify(menteeRepository).save(any(MenteeDAO.class));
    }

    @Test
    void removeMenteeOkTest() {
        MenteeDAO dao = new MenteeDAO(MENTEE_NICK, MENTEE_MAIL);
        MenteeRepository menteeRepository = mock(MenteeRepository.class);
        when(menteeRepository.findById(MENTEE_NICK)).thenReturn(Optional.of(dao));
        ModelMapper mapper = createModelMapper();
        MenteeProvider menteeProvider = new MenteeProviderImpl(menteeRepository, mapper);

        Mentee mentee = menteeProvider.removeMentee(MENTEE_NICK);

        assertEquals(MENTEE_NICK, mentee.getNick());
        assertEquals(MENTEE_MAIL, mentee.getEmail());

        verify(menteeRepository).findById(MENTEE_NICK);
        verify(menteeRepository).delete(dao);
    }

    @Test
    void removeMenteeErrorTest() {
        MenteeRepository menteeRepository = mock(MenteeRepository.class);
        when(menteeRepository.findById(MENTEE_NICK)).thenReturn(Optional.empty());
        ModelMapper mapper = createModelMapper();
        MenteeProvider menteeProvider = new MenteeProviderImpl(menteeRepository, mapper);

        assertThrows(NoSuchElementException.class, () -> menteeProvider.removeMentee(MENTEE_NICK));
    }


    private static ModelMapper createModelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
                .setFieldMatchingEnabled(true);
        return mapper;
    }
}