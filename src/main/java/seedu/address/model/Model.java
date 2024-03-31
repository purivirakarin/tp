package seedu.address.model;

import java.nio.file.Path;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.model.person.Id;
import seedu.address.model.person.Person;
import seedu.address.model.util.IdTuple;
import seedu.address.model.util.RelatedList;

import static java.util.Objects.requireNonNull;

/**
 * The API of the Model component.
 */
public interface Model {
    /**
     * {@code Predicate} that always evaluate to true
     */
    Predicate<Person> PREDICATE_SHOW_ALL_PERSONS = unused -> true;

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' netconnect file path.
     */
    Path getNetConnectFilePath();

    /**
     * Sets the user prefs' netconnect file path.
     */
    void setNetConnectFilePath(Path netConnectFilePath);

    /**
     * Replaces netconnect data with the data in {@code netConnect}.
     */
    void setNetConnect(ReadOnlyNetConnect netConnect);

    /**
     * Returns the NetConnect
     */
    ReadOnlyNetConnect getNetConnect();

    /**
     * Returns true if a person with the same identity as {@code person} exists in
     * the netconnect.
     */
    boolean hasPerson(Person person);

    /**
     * Returns true if a person with the same id as {@code Id} exists in
     * the netconnect.
     */
    boolean hasId(Id id);

    /**
     * Returns the Person with the given {@code Id}.
     */
    Person getPersonById(Id id);

    /**
     * Deletes the given person.
     * The person must exist in the address book.
     */
    void deletePerson(Person target);

    /**
     * Adds the given person.
     * {@code person} must not already exist in the address book.
     */
    void addPerson(Person person);

    /**
     * Replaces the given person {@code target} with {@code editedPerson}.
     * {@code target} must exist in the address book.
     * The person identity of {@code editedPerson} must not be the same as another
     * existing person in the address book.
     */
    void setPerson(Person target, Person editedPerson);

    /**
     * Returns an unmodifiable view of the filtered person list
     */
    ObservableList<Person> getFilteredPersonList();

    /**
     * Updates the filter of the filtered person list to filter by the given
     * {@code predicate}.
     *
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredPersonList(Predicate<Person> predicate);

    /**
     * Exports the data from the address book as a CSV file with the specified filename.
     * Returns {@code true} if the export operation is successful, {@code false} otherwise.
     */
    boolean exportCsv(String filename);

    boolean hasRelatedIdTuple(IdTuple idTuple);

    void addRelatedIdTuple(IdTuple idTuple);

    public RelatedList getRelatedIdTuples();
}
