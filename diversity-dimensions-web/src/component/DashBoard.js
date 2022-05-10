import React from "react";
import autoBind from "auto-bind";
import Header from "../Header";
import SideBarList from "../SideBarList";
export default class Dashboard extends React.Component {
    constructor(props) {
        super(props);
        autoBind(this);
    }

    render() {
        return (
            <div class="d-flex" id="wrapper">
              <SideBarList />
            <div id="page-content-wrapper">
                <Header />
                <div class="container-fluid">
                    <h1 class="mt-4">Dash Board page</h1>
                </div>
            </div>
        </div>
        );
    }

}