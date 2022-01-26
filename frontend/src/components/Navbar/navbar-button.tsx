import 'bootstrap/js/src/collapse.js';

const NavbarButton = () => {
  return (
    <button
      className="navbar-toggler"
      type="button"
      data-bs-toggle="collapse"
      data-bs-target="#dscatalog-navbar"
      aria-controls="dscatalog-navbar"
      aria-expanded="false"
      aria-label="Toggle navigation"
    >
      <span className="navbar-toggler-icon"></span>
    </button>
  );
};

export default NavbarButton;
