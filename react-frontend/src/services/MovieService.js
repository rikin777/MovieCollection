import axios from "axios";

const MOVIE_API_BASE_URL = "http://localhost:8080/api/v1/movies";

class MovieService {
  getMovies() {
    return axios.get(MOVIE_API_BASE_URL);
  }

  getMovieByName(movieName) {
    return axios.get(MOVIE_API_BASE_URL + "/" + movieName);
  }
}
export default new MovieService();
