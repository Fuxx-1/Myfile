package ltd.newimg.mapper;

import ltd.newimg.pojo.Product;
import ltd.newimg.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Eleun
 * @Description
 * @create 2022-11-20 23:49
 */
public interface ProductMapper extends JpaRepository<Product, Integer> {

}