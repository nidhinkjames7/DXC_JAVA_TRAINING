package com.dxc.MovieApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dxc.MovieApp.entity.Movie;


@Repository
public interface MovieDao extends JpaRepository<Movie, Integer> 
{

}
