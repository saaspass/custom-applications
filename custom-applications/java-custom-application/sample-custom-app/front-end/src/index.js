// recursively import all styles and scripts. exclude specs.
const context = require.context('.', true, /^(?!.*(\.spec)).*\.(css|scss|js|ts|tsx)$/);
context.keys().forEach(context);
