# imagem base dependencias
FROM node:18.15 as base

# imagem de desenvolvimento
FROM base as dev
WORKDIR /usr/src/app
COPY package*.json .
RUN npm install

# imagem de produção
# FROM base as prod
# COPY package*.json .
# RUN npm ci --only=production
# EXPOSE 3000
# CMD [ "npm", "run", "start" ]