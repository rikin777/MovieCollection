import React from "react";

const AllMoviesButton = (props) => {
  return (
    <div>
      <button style={{ marginLeft: "20px" }} onClick={props.fetchAllMovies}>
        Get all movies
      </button>
    </div>
  );
};

export default AllMoviesButton;
