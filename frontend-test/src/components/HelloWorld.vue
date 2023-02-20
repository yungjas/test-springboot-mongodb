<template>
  <div class="wrapper">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.7/css/all.css"> 
    <div>
      <input type="text" size="50" placeholder="Name">
      <input type="text"  size="50" placeholder="Email">
      <div v-for="key in countField" :key="key">
        <input type="text" v-model="values['dynamic-field-'+key]"  size="50" placeholder="Another Field" :id="key" >
      </div>

      <div v-for="key in countOption" :key="key">
        <input type="radio" v-model="values['dynamic-field-'+key]" :id="key">
      </div>

    </div>
    <div class="controls">
      <a href="#" id="add_more_fields" @click="add"><i class="fa fa-plus"></i> Add More Field</a>
      <a href="#" id="add_more_fields" @click="add"><i class="fa fa-plus"></i> Add More Option</a>
      <a href="#" id="remove_fields"  @click="remove"><i class="fa fa-plus"></i> Remove Field</a>
    </div>
    <button class="btn" @click="submit">Get Values</button>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: 'HelloWorld',
  data: function () { 
    return {
      countField: 1,
      countOption: 1,
      values: {}

    }
  },
  created(){
    axios.get("http://localhost:8080/api/vms/forms", {
      headers: {
        "Access-Control-Allow-Origin": "*",
        "Content-Type": "application/json"
      },
    }).then((response) => {
      console.log(response)
    })
  },
  methods: {
    add: function(){
      this.countField++;
    },
    remove: function () {
     this.countField--;
     
    },
    submit: function(){
     for (var key of Object.keys(this.values)) {
          console.log(key + " -> " + this.values[key])
      }
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}


body {
  background-color: #f0f5ff;
  color: #fff;
}

.btn {
  width: 50%;
  background: #3f51b5;
  color: white;
  border: 0;
  padding: 7px;
  border-radius: 5px;
}

.wrapper {
  width: 400px;
  margin: 40px auto;
  padding: 10px;
  border-radius: 5px;
  background: white;
  box-shadow: 0px 10px 40px 0px rgba(47,47,47,.1);
}

input[type="text"]{
  padding: 10px;
  margin: 10px auto;
  display: block;
  border-radius: 5px;
  border: 1px solid lightgrey;
  background: none;
  width: 274px;
  color: black;
}

input[type="text"]:focus {
  outline: none;
}

.controls {
  margin: 15px auto;
}

#remove_fields {
  float: right;
}
.controls a i.fa-minus {
  margin-right: 5px;
}

a {
  color: black;
  text-decoration: none;
}

h1 {
  text-align: center;
  font-size: 48px;
  color: #232c3d;
}
</style>
