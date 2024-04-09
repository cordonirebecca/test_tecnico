<template>
  <div class="container">
    <h1 class="text-center">UserLogin List</h1>
    <table class="table table-striped">
      <thead>
      <tr>
        <th>UserLogin Id</th>
        <th>UserLogin First Name</th>
        <th>UserLogin Last</th>
        <th>UserLogin Email</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="user in userLogin" :key="user.id">
        <td>{{ user.id }}</td>
        <td>{{ user.firstName }}</td>
        <td>{{ user.lastName }}</td>
        <td>{{ user.email }}</td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import UserServices from "../services/UserServices";

export default {
  name: 'UserLogin',
  data() {
    return {
      userLogin: []
    }
  },
  methods: {
    getUsers() {
      UserServices.getUsers().then((response) => {
        this.userLogin = response.data;
      });
    }
  },
  created() {
    this.getUsers();
  }
}
</script>
