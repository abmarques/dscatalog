import { BrowserRouter, Redirect, Route, Switch } from 'react-router-dom';
import Navbar from 'components/Navbar';
import Admin from 'pages/Admin';
import Catalog from 'pages/Catalog';
import Home from 'pages/Home';
import ProductDetails from 'pages/ProductDetails';

const Routes = () => {
  return (
    <BrowserRouter>
      <Navbar />
      <Switch>
        <Route exact path="/">
          <Home />
        </Route>
        <Route exact path="/products">
          <Catalog />
        </Route>
        <Route path="/products/:productId">
          <ProductDetails />
        </Route>
        <Redirect from="/admin" exact to="/admin/products" />
        <Route path="/admin">
          <Admin />
        </Route>
      </Switch>
    </BrowserRouter>
  );
};

export default Routes;
