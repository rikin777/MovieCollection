import React, { useState, useEffect } from "react";
import { AgGridReact } from "ag-grid-react";
import SearchBox from "./SearchBox";
import AllMoviesButton from "./AllMoviesButton";
import SearchButton from "./SearchButton";
import "../styles.css";
import "ag-grid-community/styles/ag-grid.css";
import "ag-grid-community/styles/ag-theme-alpine.css";
import MovieService from "../services/MovieService";

//Application Name – Movie Search
//1) Create a rest API endpoint which will give available movies ( Title , Type , Running Time , rating ). No need to connect to Database , just return static data .
//2) Create a search API which will take keyword and return the matched results with in Static Data
//3) Create a UI screen using React JS which will call the API and show the details  in list view .
//   Also place a small search bar where on type ahead you will call the Search API and return matched data. Use functional components of React.

export default function MovieSearch() {
  const [movieList, setMovieList] = useState([]);
  const [searchCriteria, setSearchCriteria] = useState(null);

  const [columnDefs] = useState([
    { field: "id", width: 80 },
    { field: "rank", width: 80 },
    { field: "title", width: 350 },
    { field: "type", width: 80 },
    { field: "runningtime", width: 100 },
    { field: "rating", width: 80 },
    { field: "year", width: 80 }
  ]);

  useEffect(() => {
    setMovieList([]);
  }, [searchCriteria]);

  const fetchAllMovies = () => {
    //
    MovieService.getMovies().then((res) => {
      setMovieList(res.data);
    });
    /*
    var movieList = require(".././movies.json");
    setMovieList(movieList);
    */
  };

  const searchMovie = () => {
    //fetch call with search criteria pass to server side
    if (searchCriteria) {
      MovieService.getMovieByName(searchCriteria).then((res) => {
        var movieList = res.data;
        var data = movieList.filter((movie) =>
          movie.title.toLowerCase().includes(searchCriteria.toLowerCase())
        );
        setMovieList(data);
      });
      /*
      var movieList = require(".././movies.json");
      var data = movieList.filter((movie) =>
        movie.title.toLowerCase().includes(searchCriteria.toLowerCase())
      );
      setMovieList(data);
      */
    }
  };

  return (
    <div>
      <h1>Movie Search</h1>
      <div className="movie-search-area">
        <SearchBox setSearchCriteria={setSearchCriteria} />
        <SearchButton searchMovie={searchMovie} />
        <AllMoviesButton fetchAllMovies={fetchAllMovies} />
      </div>

      <div className="ag-theme-alpine" style={{ height: 400, width: 800 }}>
        <AgGridReact rowData={movieList} columnDefs={columnDefs}></AgGridReact>
      </div>
    </div>
  );
}
