import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react-swc'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [react()],
  server: {
    port: isNaN(Number(process.env.WEB_PORT)) ? 5000 : Number(process.env.WEB_PORT),
    watch: {
      usePolling: true,
    },
  }
})
