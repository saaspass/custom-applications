export function Cached(target: any,
                       propertyName: string,
                       descriptor: TypedPropertyDescriptor<Function>) {

    const cache = {};
    const method = descriptor.value;

    descriptor.value = function (...args: any[]) {
        if (!(`${args}` in cache)) {
            cache[`${args}`] = method.apply(this, args);
        }
        return cache[`${args}`];
    };
}
