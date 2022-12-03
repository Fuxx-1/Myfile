package ltd.newimg.structural.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eleun
 * @Description
 * @create 2022-12-02 14:26
 */
public class CriteriaMale implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> malePersons = new ArrayList<>();
        for (Person person : persons) {
            if (person.getGender().equalsIgnoreCase("MALE")) malePersons.add(person);
        }
        return malePersons;
    }
}
