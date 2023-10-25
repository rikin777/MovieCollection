import axios from "axios";

const MOVIE_API_BASE_URL = "http://localhost:8080/api/v1/movies";

class MovieService {
  getAllMovies() {
    return axios.get(MOVIE_API_BASE_URL);
  }

  getMovieByCriteria(searchCriteria) {
    return axios.get(MOVIE_API_BASE_URL + "/" + searchCriteria);
  }
}
export default new MovieService();
