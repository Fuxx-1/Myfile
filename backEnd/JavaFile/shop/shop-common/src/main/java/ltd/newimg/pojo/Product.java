package ltd.newimg.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.awt.geom.GeneralPath;

/**
 * @author Eleun
 * @Description
 * @create 2022-11-20 23:22
 */
@Entity(name = "shop_product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid; // 商品id
    private String pname; // 商品名称
    private Double price; // 价格
    private Integer stock; // 库存
}
