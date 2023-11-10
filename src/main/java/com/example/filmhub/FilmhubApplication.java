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
//        user{
//            id:
//            name:
//            rated_movies: List<movie_id>
//            want_to_see: List<movie_id>
//            favorites: List<movie_id>
//        }
// 		Table movie {
//		id integer [primary key]
//		name varchar
//		production_date timestamp
//		production_country varchar
//		count_of_peaople_rated_this_movie integer
//		sum_of_total_rating double
//		description varchar
//		// List of actors
//		}
//
//		Table actor {
//		id integer [primary key]
//		real_name varchar
//		name_in_movie varchar
//		}
//
//		Table user {
//		id integer [primary key]
//		name varchar
//		rated_movies movie.id [note: 'List<movie_id>']
//		want_to_see movie.id [note: 'List<movie_id>']
//		favorites movie.id [note: 'List<movie_id>']
//		}
//
//		Ref: actor.id <> movie.id
