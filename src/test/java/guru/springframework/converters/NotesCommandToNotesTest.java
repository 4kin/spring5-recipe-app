package guru.springframework.converters;

import guru.springframework.commands.NotesCommand;
import guru.springframework.domain.Notes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class NotesCommandToNotesTest {

    public static final Long ID_VALUE = new Long(1L);
    public static final String RECIPE_NOTES = "Notes";
    NotesCommandToNotes converter;

    @BeforeEach
    public void setUp() throws Exception {
        converter = new NotesCommandToNotes();

    }

    @Test
    public void testNullParameter() throws Exception {
        Assertions.assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        Assertions.assertNotNull(converter.convert(new NotesCommand()));
    }

    @Test
    public void convert() throws Exception {
        //given
        NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(ID_VALUE);
        notesCommand.setRecipeNotes(RECIPE_NOTES);

        //when
        Notes notes = converter.convert(notesCommand);

        //then
        Assertions.assertNotNull(notes);
        Assertions.assertNotNull(ID_VALUE, String.valueOf(notes.getId()));
        Assertions.assertNotNull(RECIPE_NOTES, notes.getRecipeNotes());
    }

}