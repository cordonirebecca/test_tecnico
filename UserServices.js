// Importa Axios
import axios from 'axios';

// URL di base per le chiamate API relative agli utenti
const USER_API_BASE_URL = 'http://localhost:8080/api/users';

// Definizione della classe UserService
class UserService {
    // Metodo per ottenere la lista degli utenti
    getUsers() {
        return axios.get(USER_API_BASE_URL);
    }
}

// Esporta un'istanza della classe UserService
export default new UserService();
