package ltd.newimg.structural.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eleun
 * @Description
 * @create 2022-12-02 14:26
 */
public class CriteriaSingle implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> singlePersons = new ArrayList<>();
        for (Person person : persons) {
            if (person.getMaritalStatus().equalsIgnoreCase("SINGLE")) singlePersons.add(person);
        }
        return singlePersons;
    }
}
