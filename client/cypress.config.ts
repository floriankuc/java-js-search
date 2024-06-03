import { defineConfig } from "cypress";

module.exports = defineConfig({
  e2e: {
    // In the real world this would be in an .env
    baseUrl: 'http://localhost:5173', // Update this to your application's URL
  },
});