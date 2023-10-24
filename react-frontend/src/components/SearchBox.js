import React from "react";

const SearchBox = (props) => {
  return (
    <div>
      <input
        value={props.value}
        maxlength="50"
        placeholder="Type to search..."
        onChange={(event) => props.setSearchCriteria(event.target.value)}
      ></input>
    </div>
  );
};

export default SearchBox;
