import './App.css';
import React from "react";
import HeaderComponent from "./components/HeaderComponent";
import ListEmployeeComponent from "./components/ListEmployeeComponent";
import CreateEmployeeComponent from "./components/CreateEmployeeComponent";
import UpdateEmployeeComponent from "./components/UpdateEmployeeComponent";
import ViewEmployeeComponent from "./components/ViewEmployeeComponent";
import {Route, Switch} from "react-router-dom";
import FooterComponent from "./components/FooterComponent";

function App() {
    return (
        <Route>
            <div>
                <div>
                    <HeaderComponent/>
                </div>
                <div className="container">
                    <Switch>localhost:3000/update-employee/
                        <Route path="/" exact component={ListEmployeeComponent}/>
                        <Route path="/employees" component={ListEmployeeComponent}/>
                        <Route path="/add-employee" component={CreateEmployeeComponent}/>
                        <Route path="/update-employee/:id" component={UpdateEmployeeComponent}/>
                        <Route path="/view-employee/:id" component={ViewEmployeeComponent}/>
                    </Switch>
                </div>
                <div>
                    <FooterComponent/>
                </div>
            </div>
        </Route>
    );
}

export default App;
