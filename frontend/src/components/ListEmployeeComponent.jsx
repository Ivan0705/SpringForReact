import React from 'react';
import ListEmployeeService from "../service/ListEmployeeService";

class ListEmployeeComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            employees: []
        };
        this.addEmployee = this.addEmployee.bind(this);
        this.editEmployee = this.editEmployee.bind(this);
        this.deleteEmployee = this.deleteEmployee.bind(this);
        this.viewEmployee = this.viewEmployee.bind(this);
    }

    viewEmployee(id) {
        this.props.history.push(`/view-employee/${id}`)
    }

    deleteEmployee(id) {
        ListEmployeeService.deleteEmployee(id).then((resp => {
            this.setState({
                employees: this.state.employees.filter(employee => employee.id !== id)
            });
        }));
    }

    editEmployee(id) {
        this.props.history.push(`/update-employee/${id}`);
    }

    componentWillMount() {
        ListEmployeeService.getEmployees().then((resp) => {
            this.setState({employees: resp.data})
        });
    }

    addEmployee() {
        this.props.history.push('/add-employee')
    }

    render() {
        return (
            <div>
                <h2 className="text-center">Список контактов</h2>
                <div className="row">
                    <button className="btn btn-success" onClick={this.addEmployee}>Добавить</button>
                </div>
                <div className="row">
                    <table className="table table-striped table-bordered">
                        <thead>
                        <tr>
                            <th>Имя</th>
                            <th>Фамилия</th>
                            <th>Email</th>
                            <th>Действия</th>
                        </tr>
                        </thead>
                        <tbody>
                        {
                            this.state.employees.map(employee =>
                                <tr key={employee.id}>
                                    <td>{employee.firstName}</td>
                                    <td>{employee.lastName}</td>
                                    <td>{employee.emailId}</td>
                                    <td>
                                        <button onClick={() => this.editEmployee(employee.id)
                                        } className="btn btn-info">Редактировать
                                        </button>
                                        <button className="btn btn-danger"
                                                onClick={() => this.deleteEmployee(employee.id)}
                                                style={{marginLeft: "10px"}}>
                                            Удалить
                                        </button>
                                        <button className="btn btn-info"
                                                onClick={() => this.viewEmployee(employee.id)}
                                                style={{marginLeft: "10px"}}>
                                            Просмотр
                                        </button>
                                    </td>
                                </tr>
                            )
                        }
                        </tbody>
                    </table>

                </div>
            </div>
        )
    }
}

export default ListEmployeeComponent;