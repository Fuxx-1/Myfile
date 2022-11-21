package ltd.newimg.service;

import ltd.newimg.pojo.Product;

/**
 * @author Eleun
 * @Description
 * @create 2022-11-20 23:48
 */
public interface ProductService {
    /**
     * 根据 pid 查询商品信息
     * @param pid 商品pid
     * @return 商品信息
     */
    Product findProductByPid(Integer pid);
}
