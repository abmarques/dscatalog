import './assets/styles/custom.scss';
import './App.css';

import Navbar from 'components/Navbar';
import Catalog from 'pages/Catalog';

const App = () => {
  return (
    <>
      <Navbar />
      <Catalog />
    </>
  );
};

export default App;
