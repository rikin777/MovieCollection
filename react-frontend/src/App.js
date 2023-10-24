import React from "react";
import Home from "./components/Home";
import MovieSearch from "./components/MovieSearch";
import { BrowserRouter as Router, Link, Routes, Route } from "react-router-dom";

export default function App() {
  return (
    <Router>
      <div>
        <h2>Movie Search Application</h2>
        <nav>
          <ul>
            <li>
              <Link to={"/"}>Home</Link>
            </li>
            <li>
              <Link to={"/movieSearch"}>Movie Search</Link>
            </li>
          </ul>
        </nav>
        <hr />
        <Routes>
          <Route exact path="/" element={<Home />} />
          <Route path="/movieSearch" element={<MovieSearch />} />
        </Routes>
      </div>
    </Router>
  );
}
