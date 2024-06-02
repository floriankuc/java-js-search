import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [react()],
  test: {
    globals: true,
    testTimeout: 10000,
    environment: 'jsdom',
    // setupFiles: './src/setupTests.tsx',

  },
  build: {
    rollupOptions: {
      // https://rollupjs.org/configuration-options/
    },
  },
})
