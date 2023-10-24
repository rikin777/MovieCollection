import React from "react";

const SearchButton = (props) => {
  return (
    <div>
      <button style={{ marginLeft: "20px" }} onClick={props.searchMovie}>
        Search movie
      </button>
    </div>
  );
};

export default SearchButton;
