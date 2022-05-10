export default function SideBarList() {
    return (
       <div className="border-end bg-white" id="sidebar-wrapper">
          <div className="sidebar-heading border-bottom bg-light">Diversity Dimensions</div>
          <div className="list-group list-group-flush">
                <a className="list-group-item list-group-item-action list-group-item-light p-3" href="/dashboard">Dashboard</a>
                <a className="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Overview</a>
           </div>
        </div>);
}