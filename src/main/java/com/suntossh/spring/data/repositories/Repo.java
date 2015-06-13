package com.suntossh.spring.data.repositories;

public interface Repo<T> {

	public void insert(T rentalLocation);
	public void update(T rentalLocation);
	public void delete(T rentalLocation);
	public T getById(T rentalLocation);
	
}
