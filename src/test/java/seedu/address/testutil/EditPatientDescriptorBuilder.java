package seedu.address.testutil;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.address.model.patient.EditPatientDescriptor;
import seedu.address.model.patient.Event;
import seedu.address.model.patient.FamilyCondition;
import seedu.address.model.patient.FoodPreference;
import seedu.address.model.patient.Hobby;
import seedu.address.model.patient.Name;
import seedu.address.model.patient.Patient;
import seedu.address.model.patient.PatientHospitalId;
import seedu.address.model.patient.PreferredName;
import seedu.address.model.tag.Tag;

/**
 * A utility class to help with building EditPatientDescriptor objects.
 */
public class EditPatientDescriptorBuilder {

    private EditPatientDescriptor descriptor;

    public EditPatientDescriptorBuilder() {
        descriptor = new EditPatientDescriptor();
    }

    public EditPatientDescriptorBuilder(EditPatientDescriptor descriptor) {
        this.descriptor = new EditPatientDescriptor(descriptor);
    }

    /**
     * Returns an {@code EditPatientDescriptor} with fields containing {@code patient}'s details
     */
    public EditPatientDescriptorBuilder(Patient patient) {
        descriptor = new EditPatientDescriptor();
        descriptor.setPatientHospitalId(patient.getPatientHospitalId());
        descriptor.setName(patient.getName());
        descriptor.setPreferredName(patient.getPreferredName());
        descriptor.setFoodPreferences(patient.getFoodPreferences());
        descriptor.setFamilyConditions(patient.getFamilyConditions());
        descriptor.setHobbies(patient.getHobbies());
        descriptor.setTags(patient.getTags());
    }

    /**
     * Sets the {@code PatientHospitalId} of the {@code EditPatientDescriptor} that we are building.
     */
    public EditPatientDescriptorBuilder withPatientHospitalId(String id) {
        descriptor.setPatientHospitalId(new PatientHospitalId(id));
        return this;
    }

    /**
     * Sets the {@code Name} of the {@code EditPatientDescriptor} that we are building.
     */
    public EditPatientDescriptorBuilder withName(String name) {
        descriptor.setName(new Name(name));
        return this;
    }

    /**
     * Sets the {@code PreferredName} of the {@code EditPatientDescriptor} that we are building.
     */
    public EditPatientDescriptorBuilder withPreferredName(String preferredName) {
        descriptor.setPreferredName(new PreferredName(preferredName));
        return this;
    }

    /**
     * Parses the {@code foodPreferences} into a {@code Set<FoodPreference>}
     * and set it to the {@code EditPatientDescriptor} that we are building.
     */
    public EditPatientDescriptorBuilder withFoodPreferences(String... foodPreferences) {
        Set<FoodPreference> foodPreferenceSet = Stream.of(foodPreferences).map(FoodPreference::new)
            .collect(Collectors.toSet());
        descriptor.setFoodPreferences(foodPreferenceSet);
        return this;
    }

    /**
     * Sets the {@code familyConditions} of the {@code EditPatientDescriptor} that we are building.
     */
    public EditPatientDescriptorBuilder withFamilyConditions(String... familyConditions) {
        Set<FamilyCondition> familyConditionSet = Stream.of(familyConditions).map(FamilyCondition::new)
            .collect(Collectors.toSet());
        descriptor.setFamilyConditions(familyConditionSet);
        return this;
    }

    /**
     * Sets the {@code hobbies} of the {@code EditPatientDescriptor} that we are building.
     */
    public EditPatientDescriptorBuilder withHobbies(String... hobbies) {
        Set<Hobby> hobbySet = Stream.of(hobbies).map(Hobby::new)
            .collect(Collectors.toSet());
        descriptor.setHobbies(hobbySet);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code EditPatientDescriptor}
     * that we are building.
     */
    public EditPatientDescriptorBuilder withTags(String... tags) {
        Set<Tag> tagSet = Stream.of(tags).map(Tag::new).collect(Collectors.toSet());
        descriptor.setTags(tagSet);
        return this;
    }

    /**
     * Parses the name and dateTimeStr into a {@code Set<Event>} and set it to the
     * {@code EditPatientDescriptor} that we are building.
     */
    public EditPatientDescriptorBuilder withEvent(String name, String dateTimeStr) {
        Set<Event> events = new HashSet<>();
        events.add(new Event(name, dateTimeStr));
        descriptor.setEvents(events);
        return this;
    }


    public EditPatientDescriptor build() {
        return descriptor;
    }
}
