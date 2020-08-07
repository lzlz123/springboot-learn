package com.lizhen.dao;

import com.lizhen.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    //模拟数据

    private static Map<Integer, Employee> employees = null;

    @Autowired
    private static DepartmentDao departmentDao;

    static {
        employees = new HashMap<Integer, Employee>();//创建部门表
        employees.put(101, new Employee(101, "AA1", "11111222@qq.com", 1, departmentDao.getDepartmentByid(101), new Date()));
        employees.put(102, new Employee(102, "AA2", "11111333@qq.com", 0, departmentDao.getDepartmentByid(102), new Date()));
        employees.put(103, new Employee(103, "AA3", "11111444@qq.com", 1, departmentDao.getDepartmentByid(103), new Date()));
        employees.put(104, new Employee(104, "AA4", "11111555@qq.com", 0, departmentDao.getDepartmentByid(104), new Date()));
        employees.put(105, new Employee(105, "AA5", "11111666@qq.com", 1, departmentDao.getDepartmentByid(105), new Date()));
        employees.put(106, new Employee(106, "AA6", "11111777@qq.com", 0, departmentDao.getDepartmentByid(106), new Date()));
    }

    //增加 一个员工
    private static Integer initID = 107;

    public void sava(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initID++);
        }
        employee.setDepartment((departmentDao.getDepartmentByid(employee.getDepartment().getId())));
        employees.put(employee.getId(), employee);
    }

    public Collection<Employee> getAll() {
        return employees.values();
    }

    public Employee geEmByID(Integer id) {
        return employees.get(id);
    }

    public void delete(Integer id) {
        employees.remove(id);
    }
}
