import {
  ListItem,
  ListItemText,
  InputBase,
  Checkbox,
  ListItemSecondaryAction,
  IconButton,
} from "@material-ui/core";
import React from "react";
import { DeleteOutlined } from "@material-ui/icons";

class Todo extends React.Component {
  constructor(props) {
    super(props);
    this.state = { item: this.props.item, readOnly: true };
    this.delete = props.delete;
    this.update = props.update;
  }

  offReadOnlyMode = () => {
    console.log("Event!", this.state.readOnly);
    this.setState({ readOnly: false }, () => {
      console.log("ReadOnly?", this.state.readOnly);
    });
  };

  enterKeyEventHandler = (e) => {
    if (e.key === "Enter") {
      this.setState({ readOnly: true });
    }
    this.update(this.state.item);
  };

  editEventHandler = (e) => {
    const thisItem = this.state.item;
    thisItem.title = e.target.value;
    this.setState({ item: thisItem });
  };

  deleteEventHandler = () => {
    this.delete(this.state.item);
  };

  checkboxEventHandler = (e) => {
    const thisItem = this.state.item;
    thisItem.done = !thisItem.done;
    console.log(thisItem.done);
    this.setState({ Item: thisItem });
    this.update(this.state.item);
  };

  render() {
    const item = this.state.item;

    return (
      <ListItem>
        <Checkbox checked={item.done} onChange={this.checkboxEventHandler} />
        <ListItemText>
          <InputBase
            inputProps={{
              "aria-label": "naked",
              readOnly: this.state.readOnly,
            }}
            onClick={this.offReadOnlyMode}
            onKeyPress={this.enterKeyEventHandler}
            onChange={this.editEventHandler}
            type="text"
            id={item.id}
            name={item.id}
            value={item.title}
            multiline={true}
            fullwidth={true}
          ></InputBase>
        </ListItemText>
        <ListItemSecondaryAction>
          <IconButton
            aria-label="Delete Todo"
            onClick={this.deleteEventHandler}
          >
            <DeleteOutlined />
          </IconButton>
        </ListItemSecondaryAction>
      </ListItem>
    );
  }
}

export default Todo;
