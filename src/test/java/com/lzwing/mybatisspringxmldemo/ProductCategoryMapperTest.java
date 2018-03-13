package com.lzwing.mybatisspringxmldemo;

import com.github.pagehelper.PageHelper;
import com.lzwing.mybatisspringxmldemo.entity.PageBean;
import com.lzwing.mybatisspringxmldemo.entity.ProductCategory;
import com.lzwing.mybatisspringxmldemo.mapper.ProductCategoryMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Created By liuxiaoming
 * @CreateTime 2017/12/12 下午6:19
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles(value="dev")
@Slf4j
public class ProductCategoryMapperTest {

    @Autowired
    private ProductCategoryMapper mapper;

    @Test
    public void testAll() {
        List<ProductCategory> allItems = mapper.findAll();        //全部商品
        if (log.isDebugEnabled()) {
            log.debug("allItems:{}",allItems.size());
        }
    }

    @Test
    public void pageHelperTest() {
        int currentPage = 2;
        int pageSize = 7;
        //使用分页插件,核心代码就这一行
        PageHelper.startPage(currentPage, pageSize);

        List<ProductCategory> allItems = mapper.findAll();        //全部商品
        int countNums = mapper.countItem();            //总记录数
        PageBean<ProductCategory> pageData = new PageBean<>(currentPage, pageSize, countNums);
        pageData.setItems(allItems);

        List<ProductCategory> items = pageData.getItems();
        if (log.isDebugEnabled()) {
            for (ProductCategory item : items) {
                log.debug("item:{}",item);
            }
        }
    }

    @Test
    public void insertList4demo() {
        for(int i=17;i<17+17;i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("category_name","test"+i);
            map.put("category_type",100+i);
            int result = mapper.insertByMap(map);
            if (log.isDebugEnabled()) {
                log.debug("result:{}",result);
            }
        }
    }

    @Test
    public void insertByMap() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("category_name","吃鸡专属");
        map.put("category_type",103);
        int result = mapper.insertByMap(map);
        Assert.assertEquals(1,result);
    }

    @Test
    public void insertByObject() throws Exception {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("大吉大利");
        productCategory.setCategoryType(102);
        int result = mapper.insertByObject(productCategory);
        Assert.assertEquals(1,result);
    }

    @Test
    public void findByCategoryType() throws Exception{
        ProductCategory result = mapper.findByCategoryType(102);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByCategoryName() throws Exception{
        List<ProductCategory> result = mapper.findByCategoryName("吃鸡专属");
        Assert.assertNotEquals(0,result.size());
    }

    @Test
    public void updateByCategoryType(){
        int result = mapper.updateByCategoryType("绝地求生", 103);
        Assert.assertEquals(1, result);
    }

    @Test
    public void updateByObject(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("今晚吃鸡|大吉大利");
        productCategory.setCategoryType(102);
        int result = mapper.updateByObject(productCategory);
        Assert.assertEquals(1, result);
    }

    @Test
    public void deleteByCategoryType(){
        int result = mapper.deleteByCategoryType(102);
        Assert.assertEquals(1, result);
    }

    @Test
    public void selectByCategoryType(){
        ProductCategory result = mapper.selectByCategoryType(103);
        Assert.assertNotNull(result);
    }


}