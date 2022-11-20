import {BrowserRouter, Routes, Route} from "react-router-dom";
import Home from "./Home";
import Navbar from "./Navbar";
import Orders from "./Orders";

function Routes(){

    return(
        <BrowserRouter>
            <Navbar />
            <Routes>
                <Route path="/orders">
                    <Orders />
                </Route>
                <Route path="/">
                    <Home />
                </Route>
            </Routes>
        </BrowserRouter>
    )

}
export default Routes;