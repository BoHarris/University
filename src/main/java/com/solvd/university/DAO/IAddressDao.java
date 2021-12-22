package com.solvd.university.DAO;

import java.util.List;

import com.solvd.university.model.Address;

public interface IAddressDao<T> extends IBaseDao<Address>{
	List<T> getAllById(Long id);
}
