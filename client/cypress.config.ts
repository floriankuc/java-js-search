import { defineConfig } from "cypress";

module.exports = defineConfig({
  e2e: {
    baseUrl: 'http://localhost:5173', // Update this to your application's URL
  },
});