package ltd.newimg.structural.filter;

import java.util.List;

/**
 * @author Eleun
 * @Description
 * @create 2022-12-02 14:25
 */
public interface Criteria {
    public List<Person> meetCriteria(List<Person> persons);
}
