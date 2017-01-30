package mii.web.service;

import java.util.List;
import mii.entity.Category;
import mii.web.dao.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author user2
 */
@Service ("categoryService")
//@Transactional
public class CategoryService {
    private CategoryDAO categoryDAO;
    
    public List<Category> getAll(){
        return this.categoryDAO.getAll();
    }
    
    public CategoryDAO getCategoryDAO(){
        return categoryDAO;
    }
    
    @Autowired
    public void setCategoryDAO(CategoryDAO categoryDAO){
        this.categoryDAO = categoryDAO;
    }
    
    //===skrip tmbhn===
    public void insert(Category category){
        getCategoryDAO().insert(category);
    } 
    
    public Category getById(Long id){
        return this.categoryDAO.getById(id);
    }
    
    public void update(Category category){
        getCategoryDAO().update(category);
    }
    
    public void delete(Category category){
        getCategoryDAO().delete(category);
    }
}
