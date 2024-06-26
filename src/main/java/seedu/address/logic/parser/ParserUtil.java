package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import seedu.address.commons.util.StringUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Address;
import seedu.address.model.person.Department;
import seedu.address.model.person.Email;
import seedu.address.model.person.Id;
import seedu.address.model.person.JobTitle;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Products;
import seedu.address.model.person.Remark;
import seedu.address.model.person.Skills;
import seedu.address.model.person.TermsOfService;
import seedu.address.model.tag.Tag;
import seedu.address.model.util.TestCommandFormatUtil;

/**
 * Contains utility methods used for parsing strings in the various *Parser
 * classes.
 */
public class ParserUtil {

    /**
     * Parses {@code oneBasedIndex} into an {@code Index} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     *
     * @throws ParseException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static Id parseId(String id) throws ParseException {
        String trimmedId = id.trim();
        if (isContainSlash(trimmedId)) {
            throw new ParseException(TestCommandFormatUtil.MESSAGE_CONSTRAINTS);
        } else if (!(StringUtil.isNonZeroUnsignedInteger(trimmedId))) {
            throw new ParseException(Id.MESSAGE_CONSTRAINTS);
        }
        int parsedId = Integer.parseInt(trimmedId);
        if (!Id.isValidId(parsedId)) {
            throw new ParseException(Id.MESSAGE_CONSTRAINTS);
        }
        return Id.generateTempId(parsedId);
    }

    /**
     * Parses a {@code String name} into a {@code Name}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static Name parseName(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (isContainSlash(trimmedName)) {
            throw new ParseException(TestCommandFormatUtil.MESSAGE_CONSTRAINTS);
        } else if (!Name.isValidName(trimmedName)) {
            throw new ParseException(Name.MESSAGE_CONSTRAINTS);
        }
        return new Name(trimmedName);
    }

    /**
     * Parses a {@code String phone} into a {@code Phone}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code phone} is invalid.
     */
    public static Phone parsePhone(String phone) throws ParseException {
        requireNonNull(phone);
        String trimmedPhone = phone.trim();
        if (isContainSlash(trimmedPhone)) {
            throw new ParseException(TestCommandFormatUtil.MESSAGE_CONSTRAINTS);
        } else if (!Phone.isValidPhone(trimmedPhone)) {
            throw new ParseException(Phone.MESSAGE_CONSTRAINTS);
        }
        return new Phone(trimmedPhone);
    }

    /**
     * Parses a {@code String address} into an {@code Address}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code address} is invalid.
     */
    public static Address parseAddress(String address) throws ParseException {
        requireNonNull(address);
        String trimmedAddress = address.trim();
        if (!Address.isValidAddress(trimmedAddress)) {
            throw new ParseException(Address.MESSAGE_CONSTRAINTS);
        }
        return new Address(trimmedAddress);
    }

    /**
     * Parses a {@code String email} into an {@code Email}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code email} is invalid.
     */
    public static Email parseEmail(String email) throws ParseException {
        requireNonNull(email);
        String trimmedEmail = email.trim();
        if (isContainSlash(trimmedEmail)) {
            throw new ParseException(TestCommandFormatUtil.MESSAGE_CONSTRAINTS);
        } else if (!Email.isValidEmail(trimmedEmail)) {
            throw new ParseException(Email.MESSAGE_CONSTRAINTS);
        }
        return new Email(trimmedEmail);
    }

    /**
     * Parses a {@code String tag} into a {@code Tag}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code tag} is invalid.
     */
    public static Tag parseTag(String tag) throws ParseException {
        requireNonNull(tag);
        String trimmedTag = tag.trim();
        if (isContainSlash(trimmedTag)) {
            throw new ParseException(TestCommandFormatUtil.MESSAGE_CONSTRAINTS);
        } else if (!Tag.isValidTagName(trimmedTag)) {
            throw new ParseException(Tag.MESSAGE_CONSTRAINTS);
        }
        return new Tag(trimmedTag);
    }

    /**
     * Parses a {@code String remark} into a {@code Remark}.
     * Leading and trailing whitespaces will be trimmed.
     */
    public static Remark parseRemark(String remark) {
        requireNonNull(remark);
        return new Remark(remark);
    }

    /**
     * Parses {@code Collection<String> tags} into a {@code Set<Tag>}.
     */
    public static Set<Tag> parseTags(Collection<String> tags) throws ParseException {
        requireNonNull(tags);
        final Set<Tag> tagSet = new HashSet<>();
        for (String tagName : tags) {
            tagSet.add(parseTag(tagName));
        }
        return tagSet;
    }

    /**
     * Parses a {@code String role} into a {@code Role}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code role} is invalid.
     */
    public static String parseRole(String role) throws ParseException {
        requireNonNull(role);
        String trimmedRole = role.trim();
        if (isContainSlash(trimmedRole)) {
            throw new ParseException(TestCommandFormatUtil.MESSAGE_CONSTRAINTS);
        }
        return trimmedRole;
    }

    /**
     * Parses a {@code String department} into a {@code Department}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code department} is invalid.
     */
    public static Department parseDepartment(String department) throws ParseException {
        requireNonNull(department);
        String trimmedDepartment = department.trim();
        if (isContainSlash(trimmedDepartment)) {
            throw new ParseException(TestCommandFormatUtil.MESSAGE_CONSTRAINTS);
        } else if (!Department.isValidDepartment(trimmedDepartment)) {
            throw new ParseException(Department.MESSAGE_CONSTRAINTS);
        }
        return new Department(trimmedDepartment);
    }

    /**
     * Parses a {@code String jobTitle} into a {@code JobTitle}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code jobTitle} is invalid.
     */
    public static JobTitle parseJobTitle(String jobTitle) throws ParseException {
        requireNonNull(jobTitle);
        String trimmedJobTitle = jobTitle.trim();
        if (isContainSlash(trimmedJobTitle)) {
            throw new ParseException(TestCommandFormatUtil.MESSAGE_CONSTRAINTS);
        } else if (!JobTitle.isValidJobTitle(trimmedJobTitle)) {
            throw new ParseException(JobTitle.MESSAGE_CONSTRAINTS);
        }
        return new JobTitle(trimmedJobTitle);
    }

    /**
     * Parses a {@code String products} into a {@code Products}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code products} is invalid.
     */
    public static Products parseProducts(List<String> products) throws ParseException {
        requireNonNull(products);
        if (isContainSlash(products)) {
            throw new ParseException(TestCommandFormatUtil.MESSAGE_CONSTRAINTS);
        } else if (!Products.isValidProducts(products)) {
            throw new ParseException(Products.MESSAGE_CONSTRAINTS);
        }
        return new Products(products);
    }

    /**
     * Represents a set of skills.
     */
    public static Skills parseSkills(Collection<String> skills) throws ParseException {
        requireNonNull(skills);
        final Set<String> skillsSet = new HashSet<>();
        for (String skill : skills) {
            String trimmedSkills = skill.trim();
            if (isContainSlash(trimmedSkills)) {
                throw new ParseException(TestCommandFormatUtil.MESSAGE_CONSTRAINTS);
            } else if (!Skills.isValidSkills(trimmedSkills)) {
                throw new ParseException(Skills.MESSAGE_CONSTRAINTS);
            }
            skillsSet.add(trimmedSkills);
        }
        return new Skills(skillsSet);
    }

    /**
     * Parses a {@code String preferences} into a {@code String}.
     * Leading and trailing whitespaces will be trimmed.
     */
    public static Skills parseSkills(List<String> skills) throws ParseException {
        requireNonNull(skills);
        final Set<String> skillsSet = new HashSet<>();
        for (String skill : skills) {
            String trimmedSkills = skill.trim();
            if (isContainSlash(trimmedSkills)) {
                throw new ParseException(TestCommandFormatUtil.MESSAGE_CONSTRAINTS);
            } else if (!Skills.isValidSkills(trimmedSkills)) {
                throw new ParseException(Skills.MESSAGE_CONSTRAINTS);
            }
            skillsSet.add(trimmedSkills);
        }
        return new Skills(skillsSet);
    }

    /**
     * Parses a {@code String preferences} into a {@code String}.
     * Leading and trailing whitespaces will be trimmed.
     */
    public static String parsePreferences(String preferences) throws ParseException {
        requireNonNull(preferences);
        if (isContainSlash(preferences)) {
            throw new ParseException(TestCommandFormatUtil.MESSAGE_CONSTRAINTS);
        }
        return preferences;
    }

    /**
     * Parses the terms of service.
     *
     * @param termsOfService The terms of service to be parsed.
     * @return The parsed terms of service.
     */
    public static TermsOfService parseTermsOfService(String termsOfService) throws ParseException {
        requireNonNull(termsOfService);
        if (isContainSlash(termsOfService)) {
            throw new ParseException(TestCommandFormatUtil.MESSAGE_CONSTRAINTS);
        }
        return new TermsOfService(termsOfService);
    }

    /**
     * Checks if the given input string contains a slash ("/").
     *
     * @param input the input string to check
     * @return true if the input string contains a slash, false otherwise
     */
    public static Boolean isContainSlash(String input) {
        return input.contains("/");
    }

    /**
     * Checks if any string in the given list contains a slash.
     *
     * @param input the list of strings to check
     * @return true if any string in the list contains a slash, false otherwise
     */
    public static Boolean isContainSlash(List<String> input) {
        for (String s : input) {
            if (isContainSlash(s)) {
                return true;
            }
        }
        return false;
    }
}
