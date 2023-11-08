package com.example.filmhub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FilmhubApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilmhubApplication.class, args);
	}

}
//        movie{
//            id:
//            name:
//            prod_date:
//            produciont_country:
//            count_of_people_rated:
//            sum_of_rating:
//            description:
//            actor[
//                    id:
//                    real_name:
//                    name_in_movie:
//                    ]
//
//        }
//        account{
//            id:
//            name:
//            rated_movies:
//            want_to_see:
//            favorites:
