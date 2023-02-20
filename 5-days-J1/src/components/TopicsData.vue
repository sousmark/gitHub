<template>
    <div>
      <h1>Topics</h1>
      <input type="text" v-model="search" placeholder="Search...">
      <ul>
        <li v-for="item in filteredItems" :key="item.id">
          <h2>{{ item.title }}</h2>
          <p>{{ item.description }}</p>
        </li>
      </ul>
    </div>
  </template>
  
  <script>
  import axios from 'axios';

  export default {
    name: 'TopicsData',
    data() {
      return {
        items: [
          { id: 1, title: "Item 1", description: "Description of item 1" },
          { id: 2, title: "Item 2", description: "Description of item 2" },
          { id: 3, title: "Item 3", description: "Description of item 3" },
          { id: 4, title: "Item 4", description: "Description of item 4" },
          { id: 5, title: "Item 5", description: "Description of item 5" },
        ],
        search: "",
        filter: "",
      };
    },
    computed: {
      filteredItems() {
        return this.items.filter((item) => {
          return (
            item.title.toLowerCase().includes(this.search.toLowerCase()) ||
            item.description.toLowerCase().includes(this.search.toLowerCase()) &&
            (this.filter === "")
          );
        });
      },
    },
    mounted() {
      axios
      .get('https://api.coindesk.com/v1/bpi/currentprice.json')
      .then(response => (console.log(response)))
    }
  };
  </script>

<style scoped>
h1 {
  font-size: 2rem;
  margin-bottom: 1rem;
}
input[type="text"] {
  padding: 0.5rem;
  font-size: 1.2rem;
  margin-right: 1rem;
  border-radius: 0.25rem;
  border: 1px solid #ccc;
  width: 50%;
  max-width: 300px;
}
select {
  padding: 0.5rem;
  font-size: 1.2rem;
  margin-right: 1rem;
  border-radius: 0.25rem;
  border: 1px solid #ccc;
}
ul {
  list-style: none;
  padding: 0;
  margin-top: 4%;
}
li {
  margin-bottom: 1rem;
  padding: 1rem;
  border-radius: 0.25rem;
  border: 1px solid #ccc;
}
h2 {
  font-size: 1.5rem;
  margin-bottom: 0.5rem;
}
p {
  margin: 0;
  font-size: 1.2rem;
}
</style>