package com.lizhen.dao;

import com.lizhen.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//部门dao
@Repository
public class DepartmentDao {

    //模拟数据库中的数据
    private static Map<Integer, Department> departments = null;

    static {
        departments = new HashMap<Integer, Department>();//创建部门表
        departments.put(101, new Department(101, "====101"));
        departments.put(102, new Department(102, "====102"));
        departments.put(103, new Department(103, "====103"));
        departments.put(104, new Department(104, "====104"));
        departments.put(105, new Department(105, "====105"));
        departments.put(106, new Department(106, "====106"));
    }

    //获得所有部门信息
    public Collection<Department> getDepartment() {
        return departments.values();
    }

    //通过id 得到部门
    public Department getDepartmentByid(Integer id) {
        return departments.get(id);
    }

}
