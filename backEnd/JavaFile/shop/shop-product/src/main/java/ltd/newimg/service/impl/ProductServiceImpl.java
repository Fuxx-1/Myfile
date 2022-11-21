package ltd.newimg.service.impl;

import ltd.newimg.mapper.ProductMapper;
import ltd.newimg.pojo.Product;
import ltd.newimg.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Eleun
 * @Description
 * @create 2022-11-20 23:49
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    /**
     * 根据 pid 查询商品信息
     *
     * @param pid 商品pid
     * @return 商品信息
     */
    @Override
    public Product findProductByPid(Integer pid) {
        return productMapper.findById(pid).get();
    }
}
