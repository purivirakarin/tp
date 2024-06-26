package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.List;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Id;
import seedu.address.model.person.filter.IdContainsDigitsPredicate;
import seedu.address.model.util.IdTuple;

/**
 * Represents a command to unrelate two persons in NetConnect using either their unique id or name.
 * The unique IDs or names provided must exist.
 * Parameters: [i/ID_1] [i/ID_2]
 * Example: unrelate i/4 i/12
 */
public class UnrelateCommand extends Command {
    public static final String COMMAND_WORD = "unrelate";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Unrelates the two specified persons in NetConnect using either their unique id, OR, name.\n"
            + "The unique IDs or names provided must exist.\n"
            + "Parameters: i/ID_1 i/ID_2\n"
            + "Example: " + COMMAND_WORD + " i/4 i/12";

    private final Id firstPersonId;
    private final Id secondPersonId;

    /**
     * Creates a UnrelateCommand to unrelate the two specified {@code IdContainsDigitsPredicate}
     */
    public UnrelateCommand(Id firstPersonId, Id secondPersonId) {
        requireAllNonNull(firstPersonId, secondPersonId);

        this.firstPersonId = firstPersonId;
        this.secondPersonId = secondPersonId;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (firstPersonId.equals(secondPersonId)) {
            model.clearFilter();
            throw new CommandException(Messages.MESSAGE_CANNOT_UNRELATE_ITSELF);
        }
        // actual execution occurs here
        if (!model.hasId(firstPersonId)) {
            throw new CommandException(String.format(Messages.MESSAGE_INVALID_PERSON_ID, firstPersonId.value));
        } else if (!model.hasId(secondPersonId)) {
            throw new CommandException(String.format(Messages.MESSAGE_INVALID_PERSON_ID, secondPersonId.value));
        }

        IdTuple tuple = new IdTuple(firstPersonId, secondPersonId);

        if (!model.hasRelatedIdTuple(tuple)) {
            throw new CommandException(Messages.MESSAGE_RELATION_NOT_EXISTS);
        } else {
            model.removeRelatedIdTuple(tuple);
        }

        model.updateFilteredList(new IdContainsDigitsPredicate(List.of(firstPersonId.value, secondPersonId.value)));

        return new CommandResult(String.format(Messages.MESSAGE_UNRELATION_SUCCESS, tuple));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof UnrelateCommand)) {
            return false;
        }

        UnrelateCommand otherFindNumCommand = (UnrelateCommand) other;
        return (this.firstPersonId.equals(otherFindNumCommand.firstPersonId)
                && this.secondPersonId.equals(otherFindNumCommand.secondPersonId))
                || (this.firstPersonId.equals(otherFindNumCommand.secondPersonId)
                && this.secondPersonId.equals(otherFindNumCommand.firstPersonId));
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("first id", firstPersonId)
                .add("second id", secondPersonId)
                .toString();
    }
}
