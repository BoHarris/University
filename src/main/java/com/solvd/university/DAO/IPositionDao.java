package com.solvd.university.DAO;

import java.util.List;

import com.solvd.university.model.Position;

public interface IPositionDao<T> extends IBaseDao<Position> {
	Position getPositionById(long id);
	List<T> getListedPositionById(long id);
}
